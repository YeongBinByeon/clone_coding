from django.contrib.auth import get_user_model, login as auth_login
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin
from accounts.models import Profile
from django.views.generic import UpdateView, CreateView
from .forms import ProfileForm
from django.conf import settings


User = get_user_model()

@login_required
def profile(request):
    return render(request, 'accounts/profile.html')

@login_required
def profile_edit(request):
    try:
        profile = request.user.profile
    except Profile.DoesNotExist:
        profile = None
        #Profile.objects.get(user=request.user) #위의 코드와 같은 코드이다.

    if request.method == 'POST':
        form = ProfileForm(request.POST, request.FILES, instance=profile)
        if form.is_valid():
            profile = form.save(commit=False)
            profile.user = request.user
            profile.save()
            return redirect('profile')
    else:
        form = ProfileForm(instance=profile)
    return render(request, 'accounts/profile_form.html', {
        'form':form,
    })

class SignupView(CreateView):
    model = User
    form_class = UserCreationForm
    success_url = settings.LOGIN_REDIRECT_URL
    template_name='accounts/signup_form.html'

    def form_valid(self, form):
        response = super().form_valid(form) # 부모 호출해서 응답 먼저 받아낸다.
        user = self.object
        auth_login(self.request, user)
        return response

signup = SignupView.as_view()

def logout(request):
    pass