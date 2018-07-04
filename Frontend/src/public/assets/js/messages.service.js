class MessagesService {
    constructor() {
        this.message = null;
        this.type = null;
        this.alert = false;
    }

    getMessage() {
        return this.message;
    }

    getType() {
        return this.type;
    }

    setMessage(message, type) {
        this.message = message;
        this.type = type;
        this.alert = true;
    }

    reset() {
        this.message = null;
        this.type = null;
        this.alert = false;
    }

    hasAlert() {
        return this.alert;
    }
}

export default MessagesService;
