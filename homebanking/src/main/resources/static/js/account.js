const urlSearchParams = new URLSearchParams(window.location.search); //con esto obtengo el url de la peticion
const params = Object.fromEntries(urlSearchParams.entries());// convierto en objeto el parametro de la url solicitada anterormente

console.log(params) //dato como objeto

console.log(params.id)// valor del datos


let url = `api/accounts/${params.id}`

console.log(url)//perdifico la url que quiero hacer la peticion

fetch(url)
.then(response=> response.json())
.then(data=>{
    console.log(data)
    
    let datosCuenta = document.getElementById('cuenta')
    let cuenta = document.createElement("div");

    cuenta.innerHTML=`
        
        <h1>Cuenta ${data.number}</h1>
        <h2>Creacion :${data.creationDate}</h2>
        <h2>Balance :${data.balance}</h2>
        `
    datosCuenta.appendChild(cuenta)

    
    let table = document.getElementById('table')
    
     data.transaction.forEach(transaction => {


        let row = document.createElement("tr");

        if(transaction.type=="DEBITO"){
             row.innerHTML=`
        
            <th scope="row">${transaction.type}</th>
            <td class="bg-danger">${transaction.amount}</td>
            <td>${transaction.description}</td>
            <td>${transaction.date}</td>
        `
        table.appendChild(row)
        }else{
            row.innerHTML=`
        
            <th scope="row">${transaction.type}</th>
            <td class="bg-success">${transaction.amount}</td>
            <td>${transaction.description}</td>
            <td>${transaction.date}</td>
        `
        table.appendChild(row)
        }
      
        
    });
    
    
    
})

.catch(err=>console.log(err))


async function logOut(){
    axios.post('/api/logout')
    .then(response => window.location.href="index.html")

}