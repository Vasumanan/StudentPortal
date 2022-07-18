var staffId;
var staff;
var adminId = window.sessionStorage.getItem("adminId");
async function loadStaffdata(){
    staffId = document.getElementById("StaffId").value
     fetch('http://localhost:9191/admin/'+adminId+'/staffs/'+staffId).then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((responseJson) => {
      staff =  responseJson;
      document.getElementById("firstname").value = staff.firstname;
      document.getElementById("lastname").value = staff.lastname;
      document.getElementById("emailid").value = staff.emailId;
      document.getElementById("username").value = staff.username;
      document.getElementById("password").value = staff.password;
    })
    .catch((error) => {
      alert('INVALID STAFF ID');
      location.reload();
    });
}

async function updateStaffData(){
  const requestOptions = {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify({ 
          staffId  : document.getElementById("StaffId").value,
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