getProducts = () => {
    return fetch("/api/products")
    .then(response => response.json());
}

const createProductHtml = (productData) =>
{
    const template = `
        <div>
            <h4>${productData.name}</h4>
            <span>${productData.name}</span>
            <img src="data:image/jpeg;base64,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"/>
            <button data-id="${productData.id}">Add to cart</button>
        </div>
    `;

    const productEl = document.createElement('li');
    productEl.innerHTML = template.trim();

    return productEl;
}

document.addEventListener("DOMContentLoaded", ()=>{
    const productsListEl = document.querySelector("#productsList");
    getProducts()
        .then(productsAsJsonObj => productsAsJsonObj.map(createProductHtml))
        .then(productsAsHtmlEl => {
            productsAsHtmlEl.forEach(productEl => productsListEl.appendChild(productEl));
        })
})
