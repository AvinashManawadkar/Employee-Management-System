const API="http://localhost:8080/employees";

/* LOGIN */
function login(){
window.location="dashboard.html";
}

/* SIGNUP */
function signup(){
alert("Account Created");
window.location="login.html";
}

/* LOGOUT */
function logout(){
window.location="login.html";
}

/* ADD EMPLOYEE */
function addEmployee(){

let emp={
name:document.getElementById("name").value,
email:document.getElementById("email").value,
department:document.getElementById("dept").value,
salary:document.getElementById("salary").value
};

fetch(API,{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(emp)
})
.then(()=>loadEmployees());
}

/* LOAD EMPLOYEES */
function loadEmployees(){

fetch(API)
.then(res=>res.json())
.then(data=>{

let table="";

data.forEach(e=>{
table+=`
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.email}</td>
<td>${e.department}</td>
<td>${e.salary}</td>
<td>
<button onclick="deleteEmp(${e.id})">Delete</button>
</td>
</tr>`;
});

document.getElementById("empTable").innerHTML=table;

});
}

/* DELETE */
function deleteEmp(id){
fetch(API+"/"+id,{method:"DELETE"})
.then(()=>loadEmployees());
}

if(document.getElementById("empTable")){
loadEmployees();
}