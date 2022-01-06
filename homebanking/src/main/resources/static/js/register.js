

async function register(){
    let firstName = document.querySelector('#firstName').value
    let lastName = document.querySelector('#lastName').value
    let email = document.querySelector('#email').value
    let password = document.querySelector('#password').value

  axios.post('/api/login',`email=${email}&password=${password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})

  axios.post('/api/clients',`firstName=${firstName}&lastName=${lastName}&email=${email}&password=${password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
  .then(response => alert("te has registrado con exito"))
  .then(response => window.location.href="index.html")

  .catch(() =>{
      alert("email ya registrado")

  })

}