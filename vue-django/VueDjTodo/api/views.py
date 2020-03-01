from django.http import JsonResponse
from django.views.generic import ListView, DeleteView
from django.views.generic.list import BaseListView
from django.views.generic.edit import BaseDeleteView, BaseCreateView
# Create your views here.
from django.views.decorators.csrf import csrf_exempt
from django.utils.decorators import method_decorator
from todo.models import Todo
import json
from django.forms.models import model_to_dict

class ApiTodoLV(BaseListView):
    model = Todo
    # template_name 속성은 보여줄 html 파일이 있을때 쓰는 속성인대, 지금 json response를 할 것이기에 이 경우는 보여줄 html이 없기 때문에 안씀
    # template_name
    
    # #client에서 get 방식으로 요청을 보낼 때
    # def get(self, request, *args, **kwargs):
    #     tmpList = [
    #                 {'id':1, 'name':'d김석훈', 'todo':'Django와 Vue.js 연동 프로그램을 만들고 있습니다.'},
    #                 {'id':2, 'name':'d홍길동', 'todo':'이름을 안쓰면 홍길동으로 나와요...'},
    #                 {'id':3, 'name':'d이순신', 'todo':'신에게는 아직 열두 척의 배가 있사옵니다.'},
    #                 {'id':4, 'name':'d성춘형', 'todo':'그네 타기'},
    #                 ]
    #     return JsonResponse(data=tmpList, safe=False)

    def render_to_response(self, context, **response_kwargs):
        todoList = list(context['object_list'].values())
        return JsonResponse(data=todoList, safe=False)

@method_decorator(csrf_exempt, name='dispatch')
class ApiTodoDelV(BaseDeleteView):
    model = Todo

    def delete(self, request, *args, **kwargs):
        self.object = self.get_object()
        self.object.delete()
        return JsonResponse(data={}, safe=True, status=204)

@method_decorator(csrf_exempt, name='dispatch')
class ApiTodoCV(BaseCreateView):
    model = Todo
    fields = '__all__'

    def get_form_kwargs(self):
        kwargs = super().get_form_kwargs()
        kwargs['data'] = json.loads(self.request.body)
        return kwargs

    def form_valid(self, form):
        print("form_valid()", form)
        self.object = form.save()
        newTodo = model_to_dict(self.object)
        print(f"newTodo: {newTodo}")
        return JsonResponse(data=newTodo, status=201)

    def form_invalid(self, form):
        print("form_invalid()", form)
        print("form_invalid()", self.request.POST)
        print("form_invalid()", self.request.body.decode('utf8'))
        return JsonResponse(data=form.errors, status=400)