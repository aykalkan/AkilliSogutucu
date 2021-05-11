package com.akilliSogutucu;

public interface ISubject {
    public void attach(IObserver subscriber);
    public void detach(IObserver subcriber);
    public void notify(int mesaj);
}
