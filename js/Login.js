var username ;
var password ;
let data ;
let error;
async function validate(){
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    if (document.getElementById("admin").checked) {
       
        const response = await fetch('http://localhost:9191/admin/'+username+'/'+password);
        data = await response.json();
        error = response.statusText
        if(data>0){
            window.sessionStorage.setItem("adminId",data)
            location.href = 'staffdetails.html';
        }
        else{
            alert("INVALID USERNAME OR PASSWORD");
        }
    }
    if(document.getElementById("staff").checked){
        fetch('http://localhost:9191/staffs/'+username+'/'+password).then((response) => {
            if (response.ok) {
              return response.json();
            }
          })
          .then((responseJson) => {
            window.sessionStorage.setItem("staffId",responseJson)
            location.href = 'studentdetails.html';
          })
          .catch((error) => {
            alert('INVALID USERNAME OR PASSWORD');
            location.reload();
          });
    }
    if(document.getElementById("student").checked){
      fetch('http://localhost:9191/students/'+username+'/'+password).then((response) => {
          if (response.ok) {
            return response.json();
          }
        })
        .then((responseJson) => {
          window.sessionStorage.setItem("studentId",responseJson)
          location.href = 'studentview.html';
        })
        .catch((error) => {
          alert('INVALID USERNAME OR PASSWORD');
          location.reload();
        });
  }
}