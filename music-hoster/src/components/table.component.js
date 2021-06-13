import axios from 'axios';
import React from "react";
import ReactPlayer from "react-player"
import { withStyles } from "@material-ui/core/styles";
import Table1 from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import {toast} from 'react-toastify'; 
import 'react-toastify/dist/ReactToastify.css'; 
toast.configure();
export default class Table extends React.Component {
  constructor(props){
    super(props)
    this.state = {
        users:[],
          StyledTableCell : withStyles(theme => ({
            head: {
              backgroundColor: theme.palette.common.black,
              color: theme.palette.common.white,
              width: 130
            },
            body: {
              fontSize: 12
            }
          }))(TableCell),
          
           StyledTableRow : withStyles(theme => ({
            root: {
              "&:nth-of-type(odd)": {
                backgroundColor: theme.palette.action.hover
              }
            }
          }))(TableRow),
    }
}

componentDidMount(){
    if (window.localStorage.getItem("token")) {
        axios.defaults.headers.common[
          "Authorization"
        ] = 'Bearer '+window.localStorage.getItem("token");
        axios
          .get("http://localhost:8080/files")
          .then(response => { 
            console.log(response);
            this.setState({ users: response.data})
          })
          .catch(res => {console.log(res);
            toast.error('Session expired Please login again', 
          {position: toast.POSITION.TOP_CENTER,autoClose:3000})});
          
      }
}

 delete=(e)=>{
    console.log(e);
    let url="http://localhost:8080/files/"+e;
    axios.defaults.headers.common[
        "Authorization"
      ] = 'Bearer '+window.localStorage.getItem("token");
      axios
        .delete(url)
        .then(response => { console.log(response);
          toast.info('Music Deleted Successfully', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000})
     this.componentDidMount();
        })
        .catch(res => {console.log(res);
        toast.error('Session expired Please login again', 
      {position: toast.POSITION.TOP_CENTER,autoClose:3000});})
        
        
}
  
    render (){
        return (
            <div id="tab">
                <h1 className = "text-center"> Music List</h1>
                <TableContainer component={Paper}>
      <Table1>
        <TableHead>
          <TableRow>
            <this.state.StyledTableCell>Music name</this.state.StyledTableCell>
            <this.state.StyledTableCell>Genre</this.state.StyledTableCell>
            <this.state.StyledTableCell>Description</this.state.StyledTableCell>
            <this.state.StyledTableCell>Music</this.state.StyledTableCell>
            {/*<this.state.StyledTableCell>Edit</this.state.StyledTableCell>*/}
            <this.state.StyledTableCell>Delete</this.state.StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {
          this.state.users.map(
                                user => 
            <this.state.StyledTableRow key={user.id}>
              <this.state.StyledTableCell align="left">{user.musicName}</this.state.StyledTableCell>
              <this.state.StyledTableCell align="left">{user.genre}</this.state.StyledTableCell>
              <this.state.StyledTableCell align="left">{user.description}</this.state.StyledTableCell>
              <this.state.StyledTableCell align="left"><ReactPlayer url={user.url}width="400px"height="50px"playing={false}controls={true}/></this.state.StyledTableCell>
              {/*<this.state.StyledTableCell align="left"><button onClick={()=>this.delete(user.id)}>Edit</button></this.state.StyledTableCell>*/}
            <this.state.StyledTableCell align="left"><button onClick={()=>this.delete(user.id)}>Delete</button></this.state.StyledTableCell>         
            </this.state.StyledTableRow>
          )
          }
        </TableBody>
      </Table1>
    </TableContainer>
    </div>

)
}
}