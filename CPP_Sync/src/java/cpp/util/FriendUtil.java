/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.util;

import cpp.business.Friend;
import java.util.ArrayList;

/**
 *
 * @author zexingjackguo
 */
public class FriendUtil {
    
   public static Friend ClearFriendClass(){
        Friend clearFriend = new Friend();
        String empty = "";
        boolean Default = false;
        
        clearFriend.setFirstName(empty);
        clearFriend.setLastName(empty);
        clearFriend.setLastNameDiploma(empty);
        clearFriend.setEmail(empty);
        clearFriend.setCellPhone(empty);
        clearFriend.setDescription(empty);
        
        clearFriend.setEmployer(empty);
        clearFriend.setPosition(empty);
        clearFriend.setWorkPhone(empty);
        
        clearFriend.setPublicSpeaking(Default);
        clearFriend.setManagement(Default);
        clearFriend.setLeadership(Default);
        clearFriend.setOrganizational(Default);
        clearFriend.setTeamwork(Default);
        clearFriend.setCommunication(Default);
        clearFriend.setComputer(Default);
        
        
        
        
        return clearFriend;
        
        
    }
    
}
