package MomentoPattern;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("This module explains Momento Pattern");
        Editor editor = new Editor();
        editor.write("apple");
        editor.write("banana");
        editor.undo();
        editor.see();
    }
}

/**
 * Originator
 */
class Editor {
    private String content;
    private History history;
    Editor() {
        history = new History();
    }

    public void see() {
        System.out.println(this.content);
    }

    public void write(String content) {
        this.content = content;
        EditorState state = new EditorState();
        state.setCurrentState(this.content);
        this.history.setStates(state);
    }

    public void undo() {
        this.content = this.history.undo().getCurrentState();
    }
}

/**
 * Momento
 */
class EditorState {
    private String currentState;

    public String getCurrentState() {
        return currentState;
    }

    @Override
    public String toString() {
        return "EditorState{" +
                "currentState='" + currentState + '\'' +
                '}';
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}

/**
 * CareTaker
 */
class History {
    private Stack<EditorState> states = new Stack<>();

    public Stack<EditorState> getStates() {
        return states;
    }

    @Override
    public String toString() {
        return "MomentoPattern.History{" +
                "states=" + states +
                '}';
    }

    public void setStates(EditorState state) {
        this.states.push(state);
    }

    public EditorState undo() {
        if (!this.states.isEmpty()){
            this.states.pop();
        }
        return this.states.isEmpty() ? new EditorState() :this.states.peek();
    }
}