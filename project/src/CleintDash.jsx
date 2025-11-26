import React from 'react'
import './Nav.css'; 
import { Outlet, useNavigate } from 'react-router-dom';
import im from './assets/fast-crlogo.jpg'

function CleintDash() {

      const navigate=useNavigate();
      // console.log(id);
  return (
    <>
            <div id="background"></div>

 <nav className="nav-bar">
      <div className="nav-items">
               <div onClick={()=>navigate('welcome')}><img src={im} alt=""  id="size"/></div>
        <div onClick={() => navigate('book')}>Book Courier</div>
        <div onClick={() => navigate('status')}>Check Status</div>
        <div onClick={() => navigate('accepted')}>Accepted Orders</div>
        <div onClick={() => navigate('rejected')}>Rejected Orders</div>
        <div onClick={() => {
              navigate('/clientlogin');
              localStorage.removeItem("islogged");
          }} id="logout">Logout</div>

      </div>
      
    </nav>
    <Outlet />
      
    </>
  )
}

export default CleintDash;
