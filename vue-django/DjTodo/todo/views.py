from django.views.generic import TemplateView

# Create your views here.
class TodoVueOnlyTV(TemplateView):
    template_name = 'todo/todo_vue_only.html'