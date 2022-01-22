let users;
const getUsers = () => {
    axios.get('http://localhost:9000/products')
    .then(response => {
        users = response.data;
        for (let [index, user] of users.entries()) {
            const userDiv = document.createElement('div');
            let userName = `${user.name}`
            userDiv.innerHTML = `<h1>${user.name}</h1>`;
            userDiv.innerHTML += `<p>${user.price}</p>`;
            userDiv.innerHTML += `<img src="${user.url}" width="200" height="200"</img>`;
            console.log(`<img>${user.url}</img>`);
            userDiv.style.border = '2px solid blue';
            userDiv.style.width = '80%';
            userDiv.className = 'items';
            document.body.appendChild(userDiv);
            const button = document.createElement('button');
            localStorage.hasOwnProperty('user'+index) ? button.innerHTML = 'Remove from Cart' : button.innerHTML = 'Add to Cart';
            
            userDiv.appendChild(button);
            button.addEventListener('click', () => {
                if(localStorage.hasOwnProperty('user'+index)){
                    localStorage.removeItem('user'+index)
                }
                else{
                    localStorage.setItem('user'+index, user.id);
                }
                getItems1();
                getPrices();
                localStorage.hasOwnProperty('user'+index) ? button.innerHTML = 'Remove from Cart' : button.innerHTML = 'Add to Cart';

            });
        };
    })
    .catch(error => console.error(error));
}
getUsers();


const myPElement = document.createElement('p');
myPElement.innerHTML = 'Click Here to Buy the Items in Your cart';
document.body.appendChild(myPElement);



let button = document.createElement('button');
button.innerHTML = 'Buy Items';
document.body.appendChild(button);

button.addEventListener('click', () => {
    if (localStorage.length == 0) {
        alert("no items in cart");
    }
    else {
        //for each item in local storage, append to string
        let cart = "http://localhost:9000/orders/?";
        for (let i = 0; i < localStorage.length; i++) {
            cart += "type="+localStorage.getItem('user' + i) + "&";
        }
        cart+= "amount=" + total;
        console.log(cart);

    
        axios.post(cart,"")
        .then(response => {
            console.log(response);
        }
        )
        .catch(error => console.error(error));

    }

}
);

const myPElement2 = document.createElement('p');
myPElement2.innerHTML = 'Click Here to Remove All from Cart';
document.body.appendChild(myPElement2);

let button2 = document.createElement('button');
button2.innerHTML = 'Remove All';
document.body.appendChild(button2);

//event listener that removes all from cart
button2.addEventListener('click', () => {
    localStorage.clear();
    const divs = document.querySelectorAll('div.cart');
    const divs2 = document.querySelectorAll('div.items');
    for (let div of divs) {
        div.parentNode.removeChild(div);
    }
    for (let div of divs2) {
        div.getElementsByTagName('button')[0].innerHTML = 'Add to Cart';
    }
});  

const getItems1 = () => {

    const divs = document.querySelectorAll('div.cart');
    for (let div of divs) {
        div.parentNode.removeChild(div);
    }

    
    for (let i = 0; i < users.length; i++){
        const myDiv = document.createElement('div');
        if (localStorage.hasOwnProperty('user'+i)){
            myDiv.innerHTML = `<h1>${users[i].name}</h1>`;
            myDiv.innerHTML += `<p>${users[i].price}</p>`;
            myDiv.innerHTML += `<img src="${users[i].url}" width="200" height="200"</img>`;
            myDiv.style.border = '2px solid orange';
            myDiv.style.width = '80%';
            myDiv.style.marginTop = '2px';
            myDiv.className = 'cart';
            document.body.appendChild(myDiv);
        }
        document.body.appendChild(myDiv);
    }

}



let myh2 = document.createElement('h2');
myh2.innerHTML = 'Price: $0'
document.body.appendChild(myh2);

myh2.style.position = 'absolute';
myh2.style.top = '0';
myh2.style.right = '0';
myh2.style.marginRight = '50px';
myh2.style.marginTop = '50px';



let total = 0;
const getPrices = () =>{
    total = 0;
    for (let i = 0; i < document.querySelectorAll('div.cart').length; i++) {
        total += parseInt(document.querySelectorAll('div.cart')[i].querySelector('p').innerHTML);
    }
    myh2.innerHTML = 'Price: $' + total;

}
