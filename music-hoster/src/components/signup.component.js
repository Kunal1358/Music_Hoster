import React from "react";
import { useForm } from "react-hook-form";
import axios from 'axios';
import {toast} from 'react-toastify'; 
import 'react-toastify/dist/ReactToastify.css'; 
toast.configure();
export default function SignUp() {

    localStorage.clear();
  const { register, handleSubmit, formState: { errors }} = useForm();
  
  const onSubmit = data => {
  const url="http://localhost:8080/users/registration";
  axios.post(url,data).then((response) => {
    console.log(response);
    if(response.data)
    {
        toast.success('User Added Please Sign in', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})

    }
  }, (error) => {
    console.log(error);
    toast.warning('User already exists', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})
  });
  }
        
        return (
            <div className="inner">
            <form onSubmit={handleSubmit(onSubmit)}>
                <h3>Register</h3>
                <div className=" form-group">
                    <label for="firstname">First name</label>
                    <input type="text" className="form-control" placeholder="First name" {...register("firstname", { required: true,minLength:3, maxLength: 20 })}/>
                    {errors.firstname && errors.firstname.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                    {errors.firstname && errors.firstname.type === "minLength" && <span role="alert" style={{color: 'red'}}>Minimum of 3 Characters</span>}
                </div>

                <div className="form-group">
                    <label>Last name</label>
                    <input type="text" className="form-control" placeholder="Last name" {...register("lastname", { pattern: /^[A-Za-z]+$/ })} autoFocus/>
                    {errors.lastname && errors.lastname.type === "pattern" && <span role="alert" style={{color: 'red'}}>Should only contain alphabets</span>}
                </div>

                <div className="form-group">
                    <label>Email</label>
                    <input type="email" className="form-control" placeholder="Enter email" {...register("emailAddress", { required: true, pattern: /^[^@ ]+@[^@ ]+\.[^@ .]{2,}$/})} autoFocus/>
                    {errors.emailAddress && errors.emailAddress.type === "pattern" && <span role="alert" style={{color: 'red'}}>Invalid email</span>}
                    {errors.emailAddress && errors.emailAddress.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                </div>
                
                <div className="form-group">
                    <label>Mobile Number</label>
                    <input type="number" className="form-control" placeholder="Enter Mobile Number" {...register("mobileNumber",{ minLength:5,maxLength:10, required: true })} autoFocus />
                    {errors.mobileNumber && errors.mobileNumber.type === "maxLength" && <span role="alert" style={{color: 'red'}}>Invalid Mobile Number</span>}
                    {errors.mobileNumber && errors.mobileNumber.type === "minLength" && <span role="alert" style={{color: 'red'}}>Invalid Mobile Number</span>}
                    {errors.mobileNumber && errors.mobileNumber.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter password" {...register("password", { required: true, minLength:8 , pattern: /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/})} autoFocus />
                    {errors.password && errors.password.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                    {errors.password && errors.password.type === "pattern" && <span role="alert" style={{color: 'red'}}>Must contain an uppercase, lowecase , number and special character</span>}
                    {errors.password && errors.password.type === "minLength" && <span role="alert" style={{color: 'red'}}>Must be minimum of 8 characters</span>}
                </div>
                
                <input type="submit" className="btn btn-dark btn-lg btn-block"/>
                <p className="forgot-password text-right">
                    Already registered <a href="/sign-in">log in?</a>
                </p>
            </form>
            
            </div>
        );
    }
