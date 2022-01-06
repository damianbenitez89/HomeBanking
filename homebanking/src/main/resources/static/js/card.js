let url = `api/clients/current`

fetch(url)
.then(response=> response.json())
.then(data=>{
    console.log(data)
    console.log(data.cards)//verifico los datos
    
    let cardCredit = document.getElementById('cardsCredit')

    let cardDebit = document.getElementById('cardsDebit')

    data.cards.forEach(cards => {

        if(cards.type == "CREDIT"){
            console.log(cards)
                console.log(cards.type)
                let cardHTML= document.createElement("div")

                cardHTML.innerHTML= `<div class="p-3">
                <div class="card" style="border: none;">
                    <div class="card__front card__${cards.color}">
                    <img class="card__front-square card__square" src="img/logo.png">
                    <img class="card__front-logo card__logo" src="https://logodownload.org/wp-content/uploads/2016/10/visa-logo-1.png">  
                    <span class="card__label">${cards.color}</span>
                    <p class="card_numer">${cards.number}</p>
                    <div class="card__space-75">
                        <span class="card__label">Card holder</span>
                        <p class="card__info">${cards.cardHolder}</p>
                    </div>
                    <div class="card__space-25">
                        <span class="card__label">Expires</span>
                            <p class="card__info">10/25</p>
                            <p class="card__label">${cards.type}</p>
                    </div>
                    </div>
                    
                    <div class="card__back card__${cards.color}">
                    <div class="card__black-line"></div>
                    <div class="card__back-content">
                        <div class="card__secret">
                        <p class="card__secret--last">${cards.cvv}</p>
                        </div>
                        <img class="card__back-square card__square" src="img/logo.png">
                        <img class="card__back-logo card__logo" src="https://logodownload.org/wp-content/uploads/2016/10/visa-logo-1.png">
                        
                    </div>
                    </div>
                    
                </div>
            </div>`

            cardCredit.appendChild(cardHTML)
        }else{
            console.log(cards)
            console.log(cards.type)
            let cardDebitHTML= document.createElement("div")

            cardDebitHTML.innerHTML= `<div class="p-3">
            <div class="card" style="border: none;">
                <div class="card__front card__debit">
                <img class="card__front-square card__square" src="img/logo.png">
                <img class="card__front-logo card__logo" src="https://logodownload.org/wp-content/uploads/2016/10/visa-logo-1.png">  
                <span class="card__label">${cards.color}</span>
                <p class="card_numer">${cards.number}</p>
                <div class="card__space-75">
                    <span class="card__label">Card holder</span>
                    <p class="card__info">${cards.cardHolder}</p>
                </div>
                <div class="card__space-25">
                    <span class="card__label">Expires</span>
                        <p class="card__info">10/25</p>
                        <p class="card__label">${cards.type}</p>
                </div>
                </div>
                
                <div class="card__back card__debit">
                <div class="card__black-line"></div>
                <div class="card__back-content">
                    <div class="card__secret">
                    <p class="card__secret--last">${cards.cvv}</p>
                    </div>
                    <img class="card__back-square card__square" src="img/logo.png">
                    <img class="card__back-logo card__logo" src="https://logodownload.org/wp-content/uploads/2016/10/visa-logo-1.png">
                    
                </div>
                </div>
                
            </div>
        </div>`

        cardDebit.appendChild(cardDebitHTML)

        }
        
    });
    
    
    

    
      
})

.catch(err=>console.log(err))

async function logOut(){
    axios.post('/api/logout')
    .then(response => window.location.href="index.html")

}