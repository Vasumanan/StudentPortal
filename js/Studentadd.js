var staffId = window.sessionStorage.getItem("staffId");
async function addStudentData(){
  const requestOptions = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify({ 
          firstname: document.getElementById("firstname").value,
          lastname : document.getElementById("lastname").value,
          username : document.getElementById("username").value ,
          password : document.getElementById("password").value ,
          section : document.getElementById("section").value ,
          classNo : document.getElementById("classno").value ,
          marks :{
            englishMark : document.getElementById("englishmark").value,
            tamilMark   : document.getElementById("tamilmark").value,
            mathsMark   : document.getElementById("sciencemark").value,
            scienceMark : document.getElementById("mathsmark").value,
            socialMark  : document.getElementById("socialmark").value
          }
        })
  };
  const response = await fetch('http://localhost:8081/staffs/'+staffId+'/students/', requestOptions);
  error = response.statusText
  const data = await response.text();
  console.log(data)
  location.href = 'studentdetails.html';
}