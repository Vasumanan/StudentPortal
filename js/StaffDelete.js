let adminId=window.sessionStorage.getItem("adminId");
let staffId;
async function deleteStaffData(){
    staffId = document.getElementById("StaffId").value;
    fetch('http://localhost:8083/admin/'+adminId+'/staffs/'+staffId, { method: 'DELETE' },
    )
    .then((response) => {
        if(response.ok){
            alert('Delete successful')
            location.href = 'staffdetails.html';
        }
        else{
            alert('Invalid Staff Id')
            location.reload();
        }
       
    });
    
}