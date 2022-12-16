package ru.lyuchkov.container;

public interface Container<T> {
    public abstract T findById(int id);
    public abstract void delete(T t);
    public abstract void delete(int id);
    public abstract void add(T t);
}
