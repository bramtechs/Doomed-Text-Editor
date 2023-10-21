package com.doomhowl.doomed.windows.sides;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import static com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;

import com.doomhowl.doomed.assets.Assets;
import com.doomhowl.doomed.windows.BufferWindow;
import com.doomhowl.doomed.windows.buffers.BufferInterface;

public class FileTreeBuffer extends SideWindow {
    public FileTreeBuffer() {
        openBuffer(new FileTree(Gdx.files.external("Documents")));
    }

    private static class FileTreeNode extends Node<FileTreeNode, FileHandle, Label> {
        public FileTreeNode(FileHandle handle) {
            super(new Label(handle.name(), Assets.getSkin()));
        }
    }

    private static class FileTree extends Tree<FileTreeNode, FileHandle> implements BufferInterface {
        public FileTree(FileHandle projectFolder) {
            super(Assets.getSkin());

            // add project folder
            var rootNode = new FileTreeNode(projectFolder);
            add(rootNode);

            addNodes(rootNode, projectFolder);
        }

        private void addNodes(FileTreeNode parentNode, FileHandle handle) {
            for (var f: handle.list()) {
                var newNode = new FileTreeNode(f);
                if (f.isDirectory()) {
                    addNodes(newNode, f);
                }
                parentNode.add(newNode);
            }
        }

        @Override
        public void init() {

        }

        @Override
        public void preInit(BufferWindow win) {

        }
    }
}
