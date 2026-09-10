export interface ProductResponse{
    id: number;
    name: string;
    price: number;
    amountInStore: number;
}

export interface ProductRequest{
    name: string;
    price: number;
    amountInStore: number;
}