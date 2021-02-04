package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式;

public abstract class Handler<T> {

    protected Handler next;

    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T> {

        protected Handler<T> head;

        protected Handler<T> tail;

        public Builder<T> addHandler(Handler handler) {
            if(this.head ==null){
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
