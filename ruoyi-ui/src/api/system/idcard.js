import request from '@/utils/request'

// 查询身份归属列表
export function listIdcard(query) {
  return request({
    url: '/system/idcard/list',
    method: 'get',
    params: query
  })
}

// 查询身份归属详细
export function getIdcard(fCode) {
  return request({
    url: '/system/idcard/' + fCode,
    method: 'get'
  })
}

// 新增身份归属
export function addIdcard(data) {
  return request({
    url: '/system/idcard',
    method: 'post',
    data: data
  })
}

// 修改身份归属
export function updateIdcard(data) {
  return request({
    url: '/system/idcard',
    method: 'put',
    data: data
  })
}

// 删除身份归属
export function delIdcard(fCode) {
  return request({
    url: '/system/idcard/' + fCode,
    method: 'delete'
  })
}

// 导出身份归属
export function exportIdcard(query) {
  return request({
    url: '/system/idcard/export',
    method: 'get',
    params: query
  })


}
