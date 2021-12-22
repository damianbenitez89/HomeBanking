

let url = `api/clients/current`

fetch(url)
.then(response=> response.json())
.then(data=>{
    console.log(data)
    console.log(data.account)
    console.log(data.loans)
    
    

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
    

        let pos = 0;
    data.account.forEach(cuenta => {

      let transactionWeb = document.createElement("ul");

      cuenta.transaction.forEach(transaction=> {

        let row = document.createElement("div");
       row.innerHTML=` <li class="list-group-item">creacion: ${transaction.type}</li>
        <li class="list-group-item">Balance: ${transaction.amount}</li>
        <li class="list-group-item">creacion: ${transaction.date}</li>
        <li class="list-group-item">Balance: ${transaction.description}</li>`

        transactionWeb.appendChild(row)

      });
        
        pos ++;
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
                            ${transactionWeb}
                        </ul>
                    </div>
                  </div>
                </div>
            </div>
        `
        lista.appendChild(row)
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
  let acount = 2

  let botonA = `<button type="button" class="btn btn-primary" data-bs-toggle="button" autocomplete="off">Crear cuenta</button>`
  let botonD = `<button type="button" class="btn btn-primary" disabled data-bs-toggle="button" autocomplete="off">Crear Cuenta</button>`

  let botonCreate = document.getElementById('createAccount')

  if (acount <=3){
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



