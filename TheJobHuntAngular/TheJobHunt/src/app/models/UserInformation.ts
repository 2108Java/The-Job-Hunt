export class UserInformation {
    constructor(
        public userId: number,
        public firstName: string,
        public lastName: string,
        public street: string,
        public city: string,
        public state: string,
        public zip: number
    ){  }
}