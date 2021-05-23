export class Transaction {
    id: any;
    productID: any;
    price: any;
    quantity: any;

    constructor(id: number, productID:number, price: number) {
        this.id = id;
        this.productID = productID;
        this.price = price;
        this.quantity = 1;
    }
}
