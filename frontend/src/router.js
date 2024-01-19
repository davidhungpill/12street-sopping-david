
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"

import DeliveryManagementProductDeliveryManager from "./components/listers/DeliveryManagementProductDeliveryCards"
import DeliveryManagementProductDeliveryDetail from "./components/listers/DeliveryManagementProductDeliveryDetail"

import InventoryManagementInventoryManagementManager from "./components/listers/InventoryManagementInventoryManagementCards"
import InventoryManagementInventoryManagementDetail from "./components/listers/InventoryManagementInventoryManagementDetail"

import MyPageMessageManager from "./components/listers/MyPageMessageCards"
import MyPageMessageDetail from "./components/listers/MyPageMessageDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderManagements/orders',
                name: 'OrderManagementOrderManager',
                component: OrderManagementOrderManager
            },
            {
                path: '/orderManagements/orders/:id',
                name: 'OrderManagementOrderDetail',
                component: OrderManagementOrderDetail
            },

            {
                path: '/deliveryManagements/productDeliveries',
                name: 'DeliveryManagementProductDeliveryManager',
                component: DeliveryManagementProductDeliveryManager
            },
            {
                path: '/deliveryManagements/productDeliveries/:id',
                name: 'DeliveryManagementProductDeliveryDetail',
                component: DeliveryManagementProductDeliveryDetail
            },

            {
                path: '/inventoryManagements/inventoryManagements',
                name: 'InventoryManagementInventoryManagementManager',
                component: InventoryManagementInventoryManagementManager
            },
            {
                path: '/inventoryManagements/inventoryManagements/:id',
                name: 'InventoryManagementInventoryManagementDetail',
                component: InventoryManagementInventoryManagementDetail
            },

            {
                path: '/myPages/messages',
                name: 'MyPageMessageManager',
                component: MyPageMessageManager
            },
            {
                path: '/myPages/messages/:id',
                name: 'MyPageMessageDetail',
                component: MyPageMessageDetail
            },



    ]
})
