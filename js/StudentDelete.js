let staffId=window.sessionStorage.getItem("staffId");
let studentId;
async function deleteStudentData(){
    studentId = document.getElementById("StudentId").value;
    fetch('http://localhost:8081/staffs/'+staffId+'/students/'+studentId, { method: 'DELETE' },
    )
    .then((response) => {
        if(response.ok){
            alert('Delete successful')
            location.href = 'studentdetails.html';
        }
        else{
            alert('Invalid Student Id')
            location.reload();
        }
       
    });
    
}