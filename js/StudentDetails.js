let staffId=window.sessionStorage.getItem("staffId");
async function studentdetails(){
    var myarray =[];
    console.log(staffId)
    const response = await fetch('http://localhost:9191/staffs/'+staffId+'/students');
    myarray = await response.json();
    error = response.statusText
    console.log(myarray)
    buildtable(myarray)
}
function deleteStudent(){
    window.location.href='studentdelete.html';
}
function addStudent(){
    window.location.href='studentadd.html';
}
function editStudent(){
    window.location.href='studentEdit.html';
}
function buildtable(data){
var table = document.getElementById("students")
for(var i=0;i<data.length;i++){
    var row =`<tr style= "hover {background-color: coral;}">
               <td> ${data[i].studentId}</td>
               <td> ${data[i].firstname}</td>
               <td> ${data[i].lastname}</td>
               <td> ${data[i].username}</td>
               <td> ${data[i].password}</td>
               <td> ${data[i].marks.tamilMark}</td>
               <td> ${data[i].marks.englishMark}</td>
               <td> ${data[i].marks.mathsMark}</td>
               <td> ${data[i].marks.scienceMark}</td>
               <td> ${data[i].marks.socialMark}</td>
               <td> ${data[i].marks.total}</td>
               <td> ${data[i].marks.percentage}</td>
             </tr>`        
    table.innerHTML +=row
}
}