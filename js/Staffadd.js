
var staff;
var adminId = window.sessionStorage.getItem("adminId");

async function addStaffData(){
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify({ 
          firstname: document.getElementById("firstname").value,
          lastname : document.getElementById("lastname").value,
          username : document.getElementById("username").value ,
          password : document.getElementById("password").value,
          emailId  : document.getElementById("emailid").value})
  };
  const response = await fetch('http://localhost:8083/admin/'+adminId+'/staffs/', requestOptions);
  error = response.statusText
  const data = await response.text();
  console.log(data)
  location.href = 'staffdetails.html';
}