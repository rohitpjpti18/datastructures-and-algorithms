/*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.


    solution ran faster than 6% and memory used less than 56% of submissions;

    faster approch can be by use of priority queue or divide and conqueror
*/




/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* final_list = NULL;
        
        ListNode* last_node = final_list;
        
        while(true){
            int index = -1;
            ListNode* lowest_value_node = NULL;
            int current_lowest_value = INT32_MAX;
            
            for(int i = 0; i<lists.size(); i++){
                if(lists[i] != NULL && current_lowest_value > lists[i]->val){
                    index = i;
                    current_lowest_value = lists[i]->val;
                    lowest_value_node = lists[i];
                }
            }   
            
            if(index == -1) break;
            
            if(last_node == NULL) {
                if(lists[index]->next != NULL) lists[index] = lists[index]->next;
                else lists[index] = NULL;
                final_list = lowest_value_node;
                final_list->next = NULL;
                last_node = final_list;
            }else{
                if(lists[index]->next != NULL) lists[index] = lists[index]->next;
                else lists[index] = NULL;
                last_node->next = lowest_value_node;
                last_node = last_node->next;
                last_node->next = NULL;
            }
        }
        
        return final_list;
    }
};

