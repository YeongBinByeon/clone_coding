from django.shortcuts import render
from django.http import HttpRequest, HttpResponse
from django.views.generic import ListView

# Create your views here.
from .models import Post

post_list = ListView.as_view(model=Post)

# def post_list(request):
#     print(request)
#     qs = Post.objects.all()
#     q = request.GET.get('q','')
#     if q:
#         qs = qs.filter(message__icontains=q)
    
#     # instagram/templates/instagram/post_list.html
#     return render(request, 'instagram/post_list.html', {
#         'post_list':qs,
#         'q':q,
#     })

def post_detail(request: HttpRequest, pk: int) -> HttpResponse:
    pass

