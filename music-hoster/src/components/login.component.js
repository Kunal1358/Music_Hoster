import React from "react";
import { useForm } from "react-hook-form";
import axios from'axios'
import {toast} from 'react-toastify'; 
import 'react-toastify/dist/ReactToastify.css'; 
toast.configure();
export default function Login() {
    
  localStorage.clear();
  const { register, handleSubmit,formState: { errors } } = useForm();
  const onSubmit = data => {
  const url="http://localhost:8080/users/login";
  axios.post(url,data).then(res => {
    //console.log(res);
    if(res.data)
    {
    window.localStorage.setItem("token", res.data.token);
    window.location.href="http://localhost:3000/Dashboard";
    }
    
  })
  .catch(err => {
    //console.log(err);
    toast.error('Invalid Credentials', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})
  });
}
        return (
            <div className="inner">
            <form onSubmit={handleSubmit(onSubmit)}>
                <h3>Log in</h3>

                <div className="form-group">
                    <label>Email</label>
                    <input type="email" className="form-control" placeholder="Enter email" {...register("emailAddress", {required:true,  pattern: /^[^@ ]+@[^@ ]+\.[^@ .]{2,}$/})} autoFocus />
                    {errors.emailAddress && errors.emailAddress.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                    
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter password" {...register("password", {required:true})} autoFocus />
                    {errors.password && errors.password.type === "required" && <span role="alert" style={{color: 'red'}}>This is required</span>}
                </div>

                <button type="submit" className="btn btn-dark btn-lg btn-block">Sign in</button>
                <p className="forgot-password text-right">
                    New User <a href="/sign-up">Sign up?</a>
                </p>
            </form>
            </div>
        );
    
}
