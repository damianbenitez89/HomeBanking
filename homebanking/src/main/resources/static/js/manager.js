let url = 'api/clients'

fetch(url)
.then(response=> response.json())
.then(data=>{

    let table= document.getElementById('table')

    data.forEach(cliente => {
        let row = document.createElement("tr");
        row.innerHTML=`
        
            <th scope="row">${cliente.firstName}</th>
            <td>${cliente.lastName}</td>
            <td>${cliente.email}</td>
        `
        table.appendChild(row)
    });
    
})

.catch(err=>console.log(err))

async function logOut(){
    axios.post('/api/logout')
    .then(response => window.location.href="index.html")

}