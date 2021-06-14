import React, { Component } from 'react';
function Homepage() {
    localStorage.clear();
    return (
        <div className="paraOne">Welcome to Music Hoster
            <div className="paraTwo"><b><i>Upload your music here free of cost</i></b>
                <div className="paraThree"><b>Sign-In to continue</b></div>
            </div>
        </div>
    );
}
export default Homepage