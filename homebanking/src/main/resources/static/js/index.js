console.log(document.querySelector('#email'))

async function signIn(){
    let email = document.querySelector('#email').value
    let password = document.querySelector('#password').value

  axios.post('/api/login',`email=${email}&password=${password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
  .then(response => console.log('signed in!!!'))
  .then(response => window.location.href="accounts.html")
  .catch(() =>{
      errorMsg = "Sign in failed, check the information"   
      errorMsg.show();
  })

}


