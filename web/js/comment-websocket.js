class CommentWebSocket extends WebSocket {
    constructor(url, post_id, token) {
        super(url);
        this.post_id = post_id;
        this.token = token;
    }

    post(content) {
        this.send(JSON.stringify(
                {
                    action: 'post',
                    post_id: this.post_id,
                    token: this.token,
                    content: content
                }
        ));
    }

    get(page) {
        this.send(JSON.stringify(
                {
                    action: 'get',
                    post_id: this.post_id,
                    page: page
                }
        ));
    }
}