import React, {Component} from 'react';
//import { useForm } from "react-hook-form";
import axios from 'axios'
import Form from'./form.component';
import Table from './table.component'
 

  
   
  
export default function Dashboard() {
  
  window.onload=function(){
    //document.getElementsByClassName("nav-link")[0].style.visibilty='hidden';
    if (!window.localStorage.getItem("token")) {
    //console.log("redirect to login");
    window.location.href="http://localhost:3000/Sign-in";}
    
};

  return(
    <div>  
      <br/>
      <br/>
      <h3 className="h3">Add Music</h3><br/>
      
    <Form />
    <br/>
    <Table/>
    
    </div>
    
    );
   
    
}
