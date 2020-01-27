from django.shortcuts import render
from community.forms import *

# Create your views here.
# write함수는 request를 인자로 한다.
# 사용자의 요청이 request에 담긴다
def write(request):
    if request.method == 'POST':
        form = Form(request.POST)
        if form.is_valid():
            form.save()
    else:
        form = Form()
    return render(request, 'write.html', {'form':form})


def list(request):
    articleList = Article.objects.all()
    return render(request, 'list.html', {'articleList':articleList})