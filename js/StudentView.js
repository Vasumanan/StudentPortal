var studentId=sessionStorage.getItem("studentId");
async function loadStudentData(){
     fetch('http://localhost:9191/students/'+studentId).then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((responseJson) => {
      student =  responseJson;
      document.getElementById("firstname").value = student.firstname;
      document.getElementById("lastname").value = student.lastname;
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