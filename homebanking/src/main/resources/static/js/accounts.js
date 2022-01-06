

let url = `api/clients/current`

fetch(url)
.then(response=> response.json())
.then(data=>{
    console.log(data)
    console.log(data.account)
    console.log(data.loans)
    console.log(data.account[0].transaction)
    
    

    let lista = document.getElementById('datos')
    
    
    let row = document.createElement("div");
     row.innerHTML=`
        <ul class="list-group" >
            <li class="list-group-item active" aria-current="true">${data.firstName} ${data.lastName}</li>
            <li class="list-group-item">${data.email}</li>
            <li class="list-group-item">Cuentas Asociadas</li>
        </ul>
        `
        lista.appendChild(row)
    
        let table = document.getElementById('table')
        let tamañoAccount = 0
        let pos = 0;
    data.account.forEach(cuenta => {
      cuenta.transaction.forEach(transaction => {


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
      
        let dam= `<li class="list-group-item">creacion: damian</li>`
    });
      
        let row  = document.createElement("div");
        row.innerHTML=`
        
           <div class="accordion" id="accordionExample">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="heading${pos}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${pos}" aria-expanded="false" aria-controls="collapse${pos}">
                      cuenta : ${cuenta.number}
                    </button>
                  </h2>
                  <div id="collapse${pos}" class="accordion-collapse collapse " aria-labelledby="heading${pos}" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        <ul class="list-group">
                            <li class="list-group-item">creacion: ${cuenta.creationDate}</li>
                            <li class="list-group-item">Balance: ${cuenta.balance}</li>
                            
                        </ul>
                    </div>
                  </div>
                </div>
            </div>
        `
        
        lista.appendChild(row)
        
        tamañoAccount ++
        pos ++;
    });

    let listaPrestamos = document.getElementById('prestamos')
    
    data.loans.forEach(loan => {

      console.log(loan)
        
      pos ++;
      let row  = document.createElement("div");
      row.innerHTML=`
      
         <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="heading${pos}">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${pos}" aria-expanded="false" aria-controls="collapse${pos}">
                    Prestamo : ${loan.name}
                  </button>
                </h2>
                <div id="collapse${pos}" class="accordion-collapse collapse " aria-labelledby="heading${pos}" data-bs-parent="#accordionExample">
                  <div class="accordion-body">
                      <ul class="list-group">
                          <li class="list-group-item">Monto: ${loan.amount}</li>
                          <li class="list-group-item">Pagos: ${loan.payments}</li>
                  
                      </ul>
                  </div>
                </div>
              </div>
          </div>
      `
      listaPrestamos.appendChild(row)
  });



  // crear botton crear cuenta


  let botonA = `<button type="button" class="btn btn-primary" data-bs-toggle="button" autocomplete="off">Crear cuenta</button>`
  let botonD = `<button type="button" class="btn btn-primary" disabled data-bs-toggle="button" autocomplete="off">Crear Cuenta</button>`

  let botonCreate = document.getElementById('createAccount')
  console.log(tamañoAccount)
  if (tamañoAccount <3){
    botonCreate.innerHTML=botonA
  }else{
    botonCreate.innerHTML=botonD
  }
    
})

.catch(err=>console.log(err))

async function logOut(){
    axios.post('/api/logout')
    .then(response => window.location.href="index.html")

}


async function crearCuenta(){



axios.post('/api/clients/current/accounts')
.then(response => alert("Se creo una cuenta correctamente"))
.then(response => window.location.reload())
.catch(() =>{
    alert("no se puede crear cuenta")

})

}


