
var messageApi = Vue.resource('/cars{/car_id}')

Vue.component('message-row', {
    props: ['message'],
    template: '<div>{{ message.car_id }}: {{ message.reg_number }}</div>'
});

Vue.component('messages-list', {
    props: ['messages'], //properties - что нам приходит вроде
    template:
        '<div>' +
            '<message-row v-for="message in messages" :key="message.id" :message="message" />' +
        '</div>', //цикл v-for, для каждой переменной message в коллекции messages вызывает атрибут text
    created: function() {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    }
});

var app = new Vue({
    //идентификатор html-тега (синтаксис селектора, после решётки как бы id элемента):
    el: '#app',
    //Шаблон, так как мы убрали message из тега div
    template: '<messages-list :messages="messages" />',
    //объект формата ключ-значение:
    data: {
        messages: []
    }
});
