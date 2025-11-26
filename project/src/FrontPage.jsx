import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const FrontPage=()=>{

        const nav=useNavigate();
        useEffect(()=>{      
          localStorage.removeItem("islogged");
          localStorage.removeItem("Cid");
        },[])

 return (
  <>
    <style>
      {`
        /* Full-screen background container */
     

        /* Button container with relative positioning */
        #btns {
          position: relative;
          margin-top: 200px;
          z-index: 1; /* above background */
          /* optional: add padding or centering here */
        }

        .custom-btn {
          width: 160px;
          height: 48px;
          background-color: #d11504ff;
          color: white;
          border: none;
          border-radius: 8px;
          font-size: 18px;
          cursor: pointer;
          transition: background 0.3s, transform 0.2s;
        }

        .custom-btn:hover {
          background-color: #4400ffff;
          transform: scale(1.05);
        }

        #btn-client {
          width: 160px;
          height: 48px;
          background-color: #4bd368ff;
          color: white;
          border: none;
          border-radius: 8px;
          font-size: 18px;
          cursor: pointer;
          transition: background 0.3s, transform 0.2s;
        }

        #btn-client:hover {
          background-color: #4935aeff;
          transform: scale(1.05);
        }

        #space {
          margin-top: 15px;
        }
         #cntr {
        font-size: 3.5rem; /* larger font */
        font-weight: bold;
        color: transparent;
        background-image: linear-gradient(45deg, #ff8a2aff, #97b2c7ff, #243021ff);
        background-clip: text;
        -webkit-background-clip: text; /* for Safari */
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* soft dark shadow */
        margin-bottom: 20px;
        }

      `}
    </style>
    
    {/* Background image div */}
    <div id="background"></div>

    {/* Buttons container */}
    <div id="btns">
      <div>
        <center id="cntr">Welcome to Couriers</center>
        <center>
          <button className="custom-btn" onClick={() => nav('/adminreg')}>
            Admin
          </button>
        </center>
      </div>
      <div id="space">
        <center>
          <button id="btn-client" onClick={() => nav('/clientreg')}>
            Client
          </button>
        </center>
      </div>
    </div>
    
  </>
);

}
export default FrontPage;