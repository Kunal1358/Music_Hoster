import React from 'react'
import axios from'axios'
import {toast} from 'react-toastify'; 
import 'react-toastify/dist/ReactToastify.css'; 
import Table from './table.component'
import ReactDom from 'react-dom';
import Dashboard from './dashboard.component';

toast.configure();

class Form extends React.Component{
constructor(props){
    super(props)
this.state={
    musicname:'',
    genre:'',
    description:'',
    selectedFile:null,
  }
}
  changemusicname=(event)=>{
    this.setState({musicname:event.target.value})
  }
  changegenre=(event)=>{
    this.setState({genre:event.target.value})
  }
  changedescription=(event)=>{
    this.setState({description:event.target.value})
  }
  changefile=(event)=>{
    this.setState({ selectedFile: event.target.files[0] }); 
  }

  handleSubmit =event =>{
    event.preventDefault()
    var bodyFormData = new FormData();
    bodyFormData.append( 
      "file", 
      this.state.selectedFile, 
      this.state.selectedFile.name 
    ); 
    bodyFormData.append('musicname',this.state.musicname);
    bodyFormData.append('genre',this.state.genre);
    bodyFormData.append('description',this.state.description);
    //console.log(bodyFormData);

    axios({
        method: "post",
        url: "http://localhost:8080/upload",
        headers: { "Content-Type": "multipart/form-data", 'Authorization' :'Bearer '+window.localStorage.getItem("token")},
        data: bodyFormData,
      }).then(function (response) {
        //event.preventDefault();
        //handle success
        //console.log(response);
        toast.success('Music Added', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})
    })
      .catch(function (response) {
        //handle error
        toast.error('Session expired, Login again', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})
        //console.log(response);
      });
      window.location.reload();
      //document.getElementsByClassName('tab')[0].innerHTML=" ";
      //this.componentDidMount();    
}


//componentDidMount(){
  //document.getElementsByClassName('tab')[0].innerHTML= ''  ;
//}

delete(){
  localStorage.clear();
  window.location.href="http://localhost:3000/Sign-in";
}
render(){
    return (

      <div>
      
      <form onSubmit={this.handleSubmit}>
      
        <input className="form-control" type='text' placeholder="Music name" value={this.state.musicname} onChange={this.changemusicname} /><br/>
        
        <input className="form-control" type='text' placeholder="Genre" value={this.state.genre} onChange={this.changegenre} /><br/>
        
        <input className="form-control" type='text' placeholder="Description" value={this.state.description} onChange={this.changedescription} /><br/>
        
        <input className="files" type='file'  placeholder="Choose audio File" accept="audio/*" onChange={this.changefile} required="required"/><br/><br/>
        <button className="submit" type="submit">Submit</button> 
        <button className="logout" type="Button" onClick={()=>this.delete()}>Logout</button> 
      </form>
      <div className='tab'>
        
        </div>
      
      </div>
    );
 }
 }
 
 export default Form