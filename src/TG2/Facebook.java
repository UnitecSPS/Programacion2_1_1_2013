/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;

public class Facebook extends SocialClass implements iComment{
    private ArrayList<Comment> comments;
    
    public Facebook(String username){
        super(username);
        comments = new ArrayList<>();
    }
    
    @Override
    public void viewMyInfo() {
        System.out.println("Username: " + username);
        System.out.println("POSTS\n---------------");

        for(int p=0; p < posts.size(); p++){
            System.out.println(posts.get(p));
            for(Comment c: comments){
                if( c.postID == p)
                    System.out.println("\t" + c.message);
            }
        }
    }

    @Override
    public boolean addComment(int postID, String message){
        if( postID >= 0 && postID < posts.size()) {
            comments.add( new Comment(postID, message));
            return true;
        }
        return false;
    }
}
