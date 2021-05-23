export class Transaction {
    id: any;
    price: any;
    quantity: any;

    constructor(id: number, price: number) {
        this.id = id;
        this.price = price;
        this.quantity = 1;
    }
}
