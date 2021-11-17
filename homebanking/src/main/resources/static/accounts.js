let url = 'api/clients/1'

fetch(url)
.then(response=> response.json())
.then(data=>{
    console.log(data)
    console.log(data.account)

    
    
    
})

.catch(err=>console.log(err))
