var studentId;
var student;
var staffId = window.sessionStorage.getItem("staffId");
async function loadStudentdata(){
    studentId = document.getElementById("StudentId").value
     fetch('http://localhost:9191/staffs/'+staffId+'/students/'+studentId).then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((responseJson) => {
      student =  responseJson;
      window.sessionStorage.setItem("markId",student.marks.markId);
      document.getElementById("firstname").value = student.firstname;
      document.getElementById("lastname").value = student.lastname;
      document.getElementById("username").value = student.username;
      document.getElementById("password").value = student.password;
      document.getElementById("tamilmark").value = student.marks.tamilMark;
      document.getElementById("englishmark").value = student.marks.englishMark;
      document.getElementById("mathsmark").value = student.marks.mathsMark;
      document.getElementById("sciencemark").value = student.marks.scienceMark;
      document.getElementById("socialmark").value = student.marks.socialMark;
      document.getElementById("classno").value = student.classNo;
      document.getElementById("section").value = student.section;
      document.getElementById("total").value = student.marks.total;
      document.getElementById("percentage").value = student.marks.percentage;
    })
    .catch((error) => {
      alert('INVALID STUDENT ID');
      location.reload();
    });
}

async function updateStudentData(){
  const requestOptions = {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json;charset=UTF-8'
    },
    body: JSON.stringify({ 
          studentId  : document.getElementById("StudentId").value,
          firstname: document.getElementById("firstname").value,
          lastname : document.getElementById("lastname").value,
          username : document.getElementById("username").value ,
          password : document.getElementById("password").value,
          classNo: document.getElementById("classno").value ,
          section: document.getElementById("section").value,
          marks:{
            markId:window.sessionStorage.getItem("markId"),
            tamilMark : document.getElementById("tamilmark").value,
            englishMark : document.getElementById("englishmark").value,
            mathsMark : document.getElementById("mathsmark").value,
            scienceMark : document.getElementById("sciencemark").value,
            socialMark : document.getElementById("socialmark").value,
            total: document.getElementById("total").value ,
            percentage :document.getElementById("percentage").value
          }
        })
  };
  const response = await fetch('http://localhost:8081/staffs/'+staffId+'/students/', requestOptions);
  error = response.statusText
  const data = await response.text();
  console.log(data)
  location.href = 'studentdetails.html';
}