let adminId=window.sessionStorage.getItem("adminId");
async function staffdetails(){
    var myarray =[];
    const response = await fetch('http://localhost:9191/admin/'+adminId+'/staffs');
    myarray = await response.json();
    error = response.statusText
    buildtable(myarray)
}
function deleteStaff(){
    window.location.href='staffDelete.html';
}
function addStaff(){
    window.location.href='staffAdd.html';
}
function editStaff(){
    window.location.href='staffedit.html';
}
function buildtable(data){
var table = document.getElementById("staffs")
for(var i=0;i<data.length;i++){
    var row =`<tr style= "hover {background-color: coral;}">
               <td> ${data[i].staffId}</td>
               <td> ${data[i].firstname}</td>
               <td> ${data[i].lastname}</td>
               <td> ${data[i].emailId}</td>
               <td> ${data[i].username}</td>
               <td> ${data[i].password}</td>
             </tr>`
            
    table.innerHTML +=row
}
}