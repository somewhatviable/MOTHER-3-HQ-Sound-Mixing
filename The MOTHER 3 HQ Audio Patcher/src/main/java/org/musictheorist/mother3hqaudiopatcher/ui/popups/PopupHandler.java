package org.musictheorist.mother3hqaudiopatcher.ui.popups;

import java.util.Stack;

import javafx.application.Platform;

public final class PopupHandler {
    private Stack<Popup> popups;

    public PopupHandler() {
        this.popups = new Stack<Popup>();
    }

    public void display(Popup popup) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                popups.push(popup).display();
            }
        });
    }

    public void closeOneNow() {
        popups.pop().close();
    }

    public void closeOneLater() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                closeOneNow();
            }
        });
    }

    public void closeAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                while(!popups.empty()) closeOneNow();
            }
        });
    }
}