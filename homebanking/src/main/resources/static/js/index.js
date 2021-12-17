
async function signIn(){
    let email = document.querySelector('#email').value
    let password = document.querySelector('#password').value

  axios.post('/api/login',`email=${email}&password=${password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})

  .then(response => window.location.href="accounts.html")
  .catch(() =>{
      alert("Sign in failed, check the information")

  })

}

async function logOut(){
    axios.post('/api/logout')
    .then(response => window.location.href="index.html")

}




