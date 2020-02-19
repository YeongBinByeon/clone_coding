from django.views.generic import TemplateView, CreateView, ListView, DeleteView
from django.views.generic.list import MultipleObjectMixin
from django.urls import reverse_lazy

from todo.models import Todo

# Create your views here.
class TodoVueOnlyTV(TemplateView):
    template_name = 'todo/todo_vue_only.html'


class TodoCV(CreateView):
    model = Todo
    fields = '__all__'
    template_name = 'todo/todo_form.html'
    success_url = reverse_lazy('todo:list')


class TodoLV(ListView):
    model = Todo
    template_name = 'todo/todo_list.html'


class TodoDelV(DeleteView):
    model = Todo
    template_name = 'todo/todo_confirm_delete.html'
    success_url = reverse_lazy('todo:list')

class TodoMOMCV(MultipleObjectMixin, CreateView):
    model = Todo
    fields = '__all__'
    template_name = 'todo/todo_form_list.html'
    success_url = reverse_lazy('todo:mixin')

    def get(self, request, *args, **kwargs):
        self.object_list = self.get_queryset()
        return super().get(request, *args, **kwargs)
    
    def post(self, request, *args, **kwargs):
        self.object_list = self.get_queryset()
        return super().post(request, *args, **kwargs)