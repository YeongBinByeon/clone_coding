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

# 이때는 리스트가 아니라 게시글 하나임
def view(request, num="1"): 
    # 모델을 생성하면 ID가 저절로 생성되는대, 해당 ID로 게시물에 접근할 수 있다.
    article = Article.objects.get(id=num)
    return render(request, 'view.html', {'article':article})